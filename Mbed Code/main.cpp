	/* mbed Microcontroller Library
	 * Copyright (c) 2019 ARM Limited
	 * SPDX-License-Identifier: Apache-2.0
	 */
	#include "mbed.h"
	#include "http_request.h"
	#include "mbed_mem_trace.h"
	#include <iostream>
	Timer timer1;
	Timer timer2;
	AnalogIn Ain(A0);
	float ADCdata;
	Serial pc(USBTX, USBRX);
	/// declare network interface
	NetworkInterface* connectToNet()
	{
    	NetworkInterface *net = NetworkInterface::get_default_instance();
    	pc.printf("Establish connection ...");

	    if (!net) {
    	    pc.printf("Error! No network inteface found.\n");
        	return 0;
    	}
	    nsapi_error_t connect_status = net->connect();
		if (connect_status != NSAPI_ERROR_OK) {
        	pc.printf(" Failed to connect to network (%d)\n", connect_status);
        	return NULL;
    	}
		pc.printf("Connected to the network\n");
		return net;
	}
	void receiveGetResponse(HttpResponse* res)
	{
    	char buffer[3000];
    	char* result;
    	pc.printf("Status: %d - %s\n", res->get_status_code(), res->get_status_message().c_str());
		pc.printf("Headers:\n");
    	for (size_t ix = 0; ix < res->get_headers_length(); ix++) {
        	pc.printf("\t%s: %s\n", res->get_headers_fields()[ix]->c_str(), res->get_headers_values()[ix]->c_str());
        }
    	pc.printf("\nBody (%d bytes):\n\n%s\n", res->get_body_length(), res->get_body_as_string().c_str());  
	}
	void sendPostRequest(NetworkInterface* network, char* url, float phNum)
    {
        HttpRequest* post_req = new HttpRequest(network, HTTP_POST, url);
        post_req->set_header("Content-Type", "application/json");
        char body[60] ;
        sprintf(body ,"{\"ph\": \"%.7f\" }", phNum);
 		HttpResponse* post_res = post_req->send(body, strlen(body));
        if (!post_res) {
            printf("HttpRequest failed (error code %d)\n", post_req->get_error());
            return;
        }
 		printf("\n----- HTTP POST response -----\n");
        receiveGetResponse(post_res);
 		delete post_req; 
    }
	void sendGetRequest(NetworkInterface* network, char* url) {
		// Do a GET request {
        // By default the body is automatically parsed and stored in a buffer, this is memory heavy.
        // To receive chunked response, pass in a callback as last parameter to the constructor.
        HttpRequest* get_req = new HttpRequest(network, HTTP_GET, url);
        HttpResponse* get_res = get_req->send();
        if (!get_res) {
            pc.printf("HttpRequest failed (error code %d)\n", get_req->get_error());
            return ;
        }
		pc.printf("\n----- HTTP GET response -----\n");
        receiveGetResponse(get_res);
		delete get_req;
    }
	void switchOnRed()
	{
    	red=1;
    	green=0;
    	blue=0;
	}
	void switchOnGreen()
	{
    	red=0;
    	green=1;
    	blue=0;
	}
	void switchOnBlue()
	{
    	red=0;
    	green=0;
    	blue=1;
	}
	int main()
	{
    	timer1.start();
    	timer2.start();
    	NetworkInterface* network = connectToNet();
    	char* url = "http://192.168.1.3:8080/MeterOfPhRest/action";
    	char* url1 = "http://192.168.1.3:8080/MeterOfPhRest/phdata/add";
    	const float m = -18.75;
    	const float b = 15.53;
    	while (true) {  
        	if(timer1.read() >= 10)
        	{
            	sendGetRequest(network,url);
            	timer1.reset();
        	}
       		if(timer2.read() >= 10)
        	{
           		ADCdata=Ain;
           		float ph = ADCdata * m + b;
           		sendPostRequest(network, url1, ph);
           		timer2.reset();
        	}
    	}
	}

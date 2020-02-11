import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
  })
  export class RestClientService {
  
    baseUrl: string = "http://localhost:8080/MeterOfPhRest";   
    
    constructor(private httpClient: HttpClient) { }

    

    public getPhResults()
    {
      const headerDict = {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
      }
      
      const requestOptions = {                                                                                                                                                                                 
        headers: new HttpHeaders(headerDict)
      };
  
      return this.httpClient.get(this.baseUrl+'/phdata',requestOptions);
    }

    public sendAction( selectedAction)
    {
      return this.httpClient.put('http://localhost:8080/MeterOfPhRest/action'+`{selectedAction}`,'');
    }
  }
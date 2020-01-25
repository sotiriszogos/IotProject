import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
  })
  export class RestClientService {
  
    baseUrl: string = "http://localhost:8080/MeterOfPhRest/";   
    constructor(private httpClient: HttpClient) { }


    public getPhResults()
    {
        return this.httpClient.get(this.baseUrl+'');
    }
  }
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class RequestService{

    constructor(private http: HttpClient){}

    sendData(data, url){
        console.log("GOT DATA",data)
        const httpOptions = {
          headers: new HttpHeaders({
            'Content-Type':  'application/json',
            'Access-Control-Allow-Origin': '*',
            "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, PATCH, OPTIONS",
            'Access-Control-Allow-Headers': 'X-Requested-With, content-type, Authorization'
          })
        }
        //return this.http.get('http://10.7.176.47:8080/gtc2-ems/test');
        return this.http.post(url,data,httpOptions)
      }
}
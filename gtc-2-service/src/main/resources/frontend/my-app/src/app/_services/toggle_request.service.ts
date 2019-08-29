import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TestRequest } from '../_models/test-request';

@Injectable()
export class Toggle_RequestService{
    constructor(private http: HttpClient) { 

    }

    submitToggleTestRequest(request: TestRequest){
        return this.http.post(`/users/register`, request);
    }

}
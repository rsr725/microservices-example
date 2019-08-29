import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlertService, AuthenticationService } from '../_services';
import { RequestService } from '../_services/request.service';
import { first } from 'rxjs/operators';
import { Operation } from '../_models/operation';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-test-request',
  templateUrl: './test-request.component.html',
  styleUrls: ['./test-request.component.css']
})
export class TestRequestComponent implements OnInit {

  headendPort = '/slot=/Port=';

  loading = false;
  submitted = false;
  resetted = false;
  testRequestForm: FormGroup;
  operations= ['Toggle fibre light on', 'Toggle fibre light off', 'Toggle fibre light status']


  constructor(private fb: FormBuilder,
     private http: HttpClient,
     private requestService : RequestService
    ) {}
  
  
  ngOnInit() {
   this.testRequestForm = this.fb.group({
    oprationControl: ['Toggle fibre light on'],
    deviceId: ['', Validators.required],
    headendId: ['',Validators.required],
    headendPort: ['',Validators.required],
    job: ['',Validators.required]
   });
  
  }
  get f() { return this.testRequestForm.controls; }
  
  
  des = "";
 
  onSubmit() {
    
    this.submitted = true;
    
    // stop here if form is invalid


    this.loading = true;
    console.log("operation name "+ this.f.oprationControl.value)
    console.log("username is "+ this.f.deviceId.value)
    console.log("Password is "+ this.f.headendId.value)
    console.log("headendPort "+ this.f.headendPort.value)
    console.log("Job Type "+this.f.job.value)
    
    var obj = {
      "deviceId": this.f.deviceId.value,"headendId": this.f.headendId.value,"port": this.f.headendPort.value,"status": "Off","jobType": this.f.job.value
        
    };
    
    this.requestService.sendData(JSON.stringify(obj), 'http://10.7.176.47:8080/gtc2/set-ems-toggle-status')
    .subscribe((resp:any)=>{
      console.log("RESP",resp);
      this.des = resp.friendlyMsg;
    })
  console.log("Data Entered");
}



  // var sendData= function(data){
  //     console.log("GOT DATA",data)
  //     const httpOptions = {
  //       headers: new HttpHeaders({
  //         'Content-Type':  'application/json'
  //       })
  //     }
  //     return this.http.post('http://10.7.176.47:8080/gtc2/set-ems-toggle-status',data,httpOptions)
  //   }

   
  //   sendData(JSON.stringify(obj))
  //   .subscribe(resp=>{
  //     console.log("RESP",resp);
  //   })
  // console.log("Data Entered");
  ///this.user.reset()


    // const req = this.http.post('http://10.7.176.47:8080/gtc2/set-ems-toggle-status', {
    //   "deviceId": this.f.deviceId.value,
    //   "headendId": this.f.headendId.value,
    //   "port": this.f.headendPort.value,
    //   "status": "Off",
    // "jobType": this.f.job.value
    // })
    //   .subscribe(
    //     res => {
    //       console.log(res);
    //     },
    //     err => {
    //       console.log("Error occured");
    //     }
    //   );
  }
  // onReset(){
  //   this.resetted = true;
  //   this.testRequestForm.reset();
  // }


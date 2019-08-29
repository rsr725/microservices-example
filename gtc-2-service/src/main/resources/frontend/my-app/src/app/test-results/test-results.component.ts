import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { RequestService } from '../_services/request.service';
@Component({
  selector: 'app-test-results',
  templateUrl: './test-results.component.html',
  styleUrls: ['./test-results.component.css']
})
export class TestResultsComponent implements OnInit {
  obj : any = {deviceId:'',createdTime:'',modifiedTime:''};
  loading = false;
  submitted = false;
  resetted = false;
  testResultForm: FormGroup;


  constructor(private fb: FormBuilder,  private requestService : RequestService) {}
  ngOnInit() {
    this.testResultForm = this.fb.group({
    ein: ['', Validators.required],
    name: ['', Validators.required],
    deviceId: ['',Validators.required],
    fromDate: ['',],
    toDate: ['',]
   });
  }

  get f() { return this.testResultForm.controls; }
  
  submit = function() {
    
    var url = "http://10.7.176.47:8080/gtc2/get-log-by";
// -cr-md
    console.log("device id "+this.f.deviceId.value);
    console.log("device id "+this.f.fromDate.value);
    console.log("device id "+this.f.toDate.value);
    if(this.f.deviceId.value) {

      this.obj.deviceId = this.f.deviceId.value;
      url = url+"-deviceid/";
    }
    if(this.f.fromDate.value && this.f.toDate.value) {
      this.obj.createdTime = this.f.fromDate.value;
      this.obj.modifiedTime = this.f.toDate.value;
      url = url+"-cr-md/";
    }
        console.log("GOT DATA",this.obj)
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type':  'application/json',
          'Access-Control-Allow-Origin': '*',
          "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, PATCH, OPTIONS",
          'Access-Control-Allow-Headers': 'X-Requested-With, content-type, Authorization'
        })
      }
      //return this.http.get('http://10.7.176.47:8080/gtc2-ems/test');
      this.requestService.sendData(JSON.stringify(this.obj),url)
      .subscribe((resp:any)=>{
        console.log("RESP",resp);
        this.testResults = resp;
      })
      
    }
  
   onSubmit() {
    
    this.submitted = true;
    this.loading = true;
    // console.log("from date"+this.f.fromDate.value)
    this.submit();
    
  console.log("Data Entered");
}


}

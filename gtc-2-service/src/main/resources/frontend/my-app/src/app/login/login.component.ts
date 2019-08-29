import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AlertService, AuthenticationService } from '../_services';

@Component({
  selector : 'login',
  templateUrl: 'login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    
  newUser:string = "admin";
  newPassword:string = "admin" 
    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    employeeType ="Select Employee Type";
    employees = ['Direct Labor', 'Third Party'];
    placeholder:string;
   
  

    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService) {}

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            employee: [Validators.required],
            username: ['', Validators.required],
            password: ['admin', Validators.required]
        });

        // reset login status
        this.authenticationService.logout();

        // get return url from route parameters or default to '/'
        //this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    data = require('src/Users.json');
    console.log("Json data : ", JSON.stringify(data));

    changeEmployeeType(event) {
        if(this.f.employee.value==="Direct Labor"){
            this.placeholder = "Please enter your EIN";
        }else{
            this.placeholder = "Please enter your e-mail";
        }
     }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;
        console.log("employee type is"+ this.f.employee.value)
        console.log("username is"+ this.f.username.value)
        console.log("Password is"+ this.f.password.value)

        if(this.f.username.value ===this.newUser && this.f.password.value ===this.newPassword){
          alert("success");
          this.loading = false;
          this.router.navigate(['/home']);
        }else{
          alert("fail");
          this.loading = false;
        }

        



        // this.authenticationService.login(this.f.username.value, this.f.password.value)
        //     .pipe(first())
        //     .subscribe(
        //         data => {
        //             this.router.navigate([this.returnUrl]);
        //         },
        //         error => {
        //             this.alertService.error(error);
        //             this.loading = false;
        //         });
    }
}

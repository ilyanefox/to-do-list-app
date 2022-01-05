import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {RegistrationService} from "../registration.service";
import {User} from "../user";
import {HttpErrorResponse} from "@angular/common/http";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User();
  msg = '';
  constructor(private _service : RegistrationService, private _router : Router) { }

  ngOnInit(): void {
  }

  loginUser() {
    this._service.loginUserFromRemote(this.user).subscribe({
      // next: console.log("response received");
      next: (response: User) => {
        console.log("response received")
        this._router.navigate(['/loginsuccess'])
      },
      error:  (error: HttpErrorResponse) => {
        console.log("exception occurred");
        this.msg="Please enter valid email and password"
      }
   });
  }
}

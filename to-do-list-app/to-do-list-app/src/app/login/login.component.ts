import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {RegistrationService} from "../registration.service";
import {User} from "../user"
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

  constructor(private _service: RegistrationService, private _router: Router) {
  }

  ngOnInit(): void {
  }

  //Subscribe function defines how to obtain or generate values or messages to be published
  email: any;
  loginUser() {
    this._service.loginUserFromRemote(this.user).subscribe({
      next: (response: User) => {
        console.log("response received")
        this._router.navigate(['/add-task'])
      },
      error: (error: HttpErrorResponse) => {
        console.log(error.error);
        this.msg = "Please enter valid email and password"
      }
    });
  }
}

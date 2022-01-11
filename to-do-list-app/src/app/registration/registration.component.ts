import { Component, OnInit } from '@angular/core';
import { NgForm } from "@angular/forms";
import {User} from "../user";
import {RegistrationService} from "../registration.service";
import {Router} from "@angular/router";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

user = new User;
msg = '';

  constructor(private _service : RegistrationService, private _router : Router) { }

  ngOnInit() {
  }

  registerUser() {
    this._service.registerUserFromRemote(this.user).subscribe({
      next: (response: User) => {
      console.log("response received")
        this._router.navigate(['/login']).then();
        // this.msg="Registration successful";
      },
      error:  (error: HttpErrorResponse) => {
        this.msg=error.error;
      console.log(this.msg);

    }
  });

  }
}

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

  //Subscribe function defines how to obtain or generate values or messages to be published
  registerUser() {
    this._service.registerUserFromRemote(this.user).subscribe({
      next: (response: User) => {
      console.log("response received")
        this._router.navigate(['/profile']).then();
      },
      error:  (error: HttpErrorResponse) => {
      console.log("User with this email already exists");
        this.msg = "Uh oh! A user with this email already exists";
    }
  });

    // getUserByFirstName(): void {
    //   this._service.findUserByFirstName(this.user).subscribe({
    //     next: (response: User) => {
    //       this.user = response;
    //
    //     }
    //   });
    // }
  }
}

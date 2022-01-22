import { Component, OnInit } from "@angular/core";
import { FormArray, FormControl, FormGroup, Validators } from "@angular/forms";


import {HttpErrorResponse} from "@angular/common/http";
import {User} from "../user";
import {AuthService} from "../auth.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
})
export class RegisterComponent implements OnInit {
  // @ts-ignore
  registrationForm: FormGroup
  user = new User();
  isRegistered = false;
  submitted = false;
  errorMessage: any = '';

  // roles: any = [
  //   {name:'User', id:1, selected: true},
  //   {name:'Admin', id:2, selected: false},
  // ]
  // selectedRoles: string[];
  constructor(private authService: AuthService) {
  }

  ngOnInit() {
    this.registrationForm = new FormGroup({
      firstName: new FormControl(null, [Validators.required, Validators.minLength(5), Validators.maxLength(20)]),
      email: new FormControl(null, [Validators.required, Validators.email]),
      pwHash: new FormControl(null, [Validators.required, Validators.minLength(8)]),
      // roleSelection: this.createRoles(this.roles)
    });
  }
    // }
    // Create form array
    // createRoles(rolesList): FormArray{
    //   const arr = rolesList.map(role => {
    //     return new FormControl(role.selected)
    //   });
    //   return new FormArray(arr);

    // }
    onSubmit() {
      this.submitted = true;
      this.user.userName = this.registrationForm.value.userName;
      this.user.email = this.registrationForm.value.email;
      this.user.pwHash = this.registrationForm.value.password;
      //console.log(this.getSelectedRoles());
      // this.user.roles = this.getSelectedRoles();
      this.registerUser()
    }


  registerUser() {
    this.authService.signup(this.user)
      .subscribe({
        next: (response: User) => {
          console.log(this.user);
          this.isRegistered = true;
        },
        error: (error: HttpErrorResponse) => {
          console.log(error);
          this.errorMessage = error;
          this.isRegistered = false;
        }
      });
  }
  }




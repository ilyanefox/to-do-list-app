import { Component, OnInit } from '@angular/core';
import {User} from "../user";
import { RegistrationService } from "../registration.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor() { }


  ngOnInit(): void {

  }

}

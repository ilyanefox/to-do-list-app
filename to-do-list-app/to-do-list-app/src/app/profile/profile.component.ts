import {Component, OnInit, ViewChild} from '@angular/core';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { MatChipInputEvent } from '@angular/material/chips';

import {Categories} from "../categories";
import {MatIcon} from "@angular/material/icon";
import { MatChipList} from "@angular/material/chips";
import {User} from "../user";
import {HttpErrorResponse} from "@angular/common/http";
import {RegistrationService} from "../registration.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ProfileService} from "../profile.service";
import {FormGroup} from "@angular/forms";

export interface Categories {
  name: string;
}
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  public visible = true;
  public selectable = true;
  public removable = true;
  public addOnBlur = true;
  @ViewChild('chipList', { static: true }) chipList: any;
  // @ts-ignore
  categoryForm: FormGroup;
  public categoryArray: Categories[] = [];
  readonly separatorKeysCodes: number[] = [ENTER, COMMA];
  // public user: User = new User();

  public msg = '';
  user = {
    id: '',
    email: '',
    pwHash: '',
    firstName: '',
    categories: [],
    toDoList: []
  };
  ngOnInit():any{
    this.updateBookForm();
  }
  // constructor(private _service: RegistrationService, private profileService: ProfileService, private _router: Router) {
  // }
  constructor(
    // public fb: FormBuilder,
    private router: Router,

    private actRoute: ActivatedRoute,

  ) {
    let id = this.actRoute.snapshot.paramMap.get('id');
    this.profileService.GetStudent(id).subscribe(data => {
      console.log(data.subjects)
      this.subjectArray = data.subjects;
      this.studentForm = this.fb.group({
        student_name: [data.student_name, [Validators.required]],
        student_email: [data.student_email, [Validators.required]],
        section: [data.section, [Validators.required]],
        subjects: [data.subjects],
        dob: [data.dob, [Validators.required]],
        gender: [data.gender]
      })
    })
  }

  updateBookForm() {
    this.studentForm = this.fb.group({
      student_name: ['', [Validators.required]],
      student_email: ['', [Validators.required]],
      section: ['', [Validators.required]],
      subjects: [this.subjectArray],
      dob: ['', [Validators.required]],
      gender: ['Male']
    })
  }


  add(event: MatChipInputEvent): void {
    const value = (event.value || '').trim();
    // Add language
    if (value) {
      this.categoryArray.push({name: value.trim()})
    }
    // Reset the input value
    event.chipInput!.clear();
  }

  /* Remove dynamic languages */
  remove(category: Categories): void {
    const index = this.categoryArray.indexOf(category);
    if (index >= 0) {
      this.categoryArray.splice(index, 1);
    }
  }

//   public category = '';
//   splitArray() {
//     for (let  i = 0; i < this.categoryArray.length; i++){
//      this.categoryArray.splice(0,1)
//
//     }
//   }
// spliceArray() {
//   for (let category in this.categoryArray) {
//
//   }
// }





addCategory() {
  for (let category in this.categoryArray) {

    this.profileService.addCategory(this.).subscribe({
      next: (response: Categories) => {
        console.log("response received")
        // this._router.navigate(['/profile']).then();
      },
      // error: (error: HttpErrorResponse) => {
      //   console.log("Category already exists");
      //   this.msg = "Uh oh! Category already exists";
      // }
    });
  }
  }
}

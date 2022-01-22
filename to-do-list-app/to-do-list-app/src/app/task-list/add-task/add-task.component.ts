import { Component, OnInit } from '@angular/core';
import {TaskService} from "../../task.service";
import {HttpErrorResponse} from "@angular/common/http";
import {User} from "../../user";
import {Router} from "@angular/router";
import {Task} from "../../task";
import {Category} from "../../category";

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {


  constructor(private taskService: TaskService, private _router: Router) {
  }

  ngOnInit() {
    this.addTask();
  }
  public task: any = new Task();

  // public category: any = new Category();

  public addTask(): any {
    this.taskService.addTask(this.task).subscribe({
      next: (response) => {
        console.log("response received");
        this.task.name = '';
        this.task.category = '';
        // this.category.name = '';
        // this._router.navigate(['/task-list']).then();
      },
      error: (error: HttpErrorResponse) => {
      console.log("some sort of error");

    }
    });
  }
}


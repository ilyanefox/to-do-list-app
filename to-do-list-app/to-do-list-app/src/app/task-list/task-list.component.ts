import { Component, OnInit } from '@angular/core';
import {TaskService} from "../task.service";
import {HttpErrorResponse} from "@angular/common/http";
import {Task} from "../task";

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  public tasks: Task[] = [];
  constructor(private taskService: TaskService) { }

  ngOnInit() {
    this.getTasks();

  }

  public getTasks(): void {
    this.taskService.getTasks().subscribe({
      next: (response: Task[]) => {
        this.tasks = response;
      },
      error: (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    });
  }
}

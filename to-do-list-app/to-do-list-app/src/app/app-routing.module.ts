import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {RegistrationComponent} from "./registration/registration.component";
import {ProfileComponent} from "./profile/profile.component";
import {AddTaskComponent} from "./task-list/add-task/add-task.component";
import {TaskListComponent} from "./task-list/task-list.component";

const routes: Routes = [
  {path:'', component:LoginComponent},
  {path:'profile', component:ProfileComponent},
  {path:'registration', component:RegistrationComponent},
  {path:'login', component:LoginComponent},
  {path:'add-task', component:AddTaskComponent},
  {path:'task-list', component:TaskListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

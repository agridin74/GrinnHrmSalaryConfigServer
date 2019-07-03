import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateSlrdepartmentComponent } from "./components/slrdepartment/create-slrdepartment/create-slrdepartment.component";
import { SlrdepartmentDetailsComponent } from "./components/slrdepartment/slrdepartment-details/slrdepartment-details.component";
import { SlrdepartmentListComponent } from "./components/slrdepartment/slrdepartment-list/slrdepartment-list.component";
const routes: Routes = [
  { path: '', redirectTo: 'slrdepartment', pathMatch: 'full'},
  { path: 'slrdepartments', component: SlrdepartmentListComponent },
  { path: 'add', component: CreateSlrdepartmentComponent},
  { path: 'details/:id', component: SlrdepartmentDetailsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

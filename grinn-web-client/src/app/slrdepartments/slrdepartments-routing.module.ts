/**
 * @author Alex Gridin
 */

 import { NgModule } from '@angular/core';
 import { RouterModule, Routes } from '@angular/router';
 import { SlrdepartmentDetailsComponent } from './slrdepartment-detail/slrdepartment-details.component';
 import { SlrdepartmentListComponent } from './slrdepartment-list/slrdepartment-list.component';
 import { SlrdepartmentEditComponent } from './slrdepartment-edit/slrdepartment-edit.component';
 import { CreateSlrdepartmentComponent } from './slrdepartment-add/slrdepartment-add.component';
 import { AuthGaurdService } from '../auth/auth-gaurd.service';

 
 const slrdepartmentRoutes: Routes = [
     {path: 'slrdepartments', component: SlrdepartmentListComponent, canActivate: [AuthGaurdService]},
     {path: 'slrdepartments/add', component: CreateSlrdepartmentComponent, canActivate: [AuthGaurdService]},
     {path: 'slrdepartments/:id', component: SlrdepartmentDetailsComponent, canActivate: [AuthGaurdService]},
     {path: 'slrdepartments/:id/edit', component: SlrdepartmentEditComponent, canActivate: [AuthGaurdService]}
 ];

 @NgModule({
     imports: [RouterModule.forChild(slrdepartmentRoutes)],
     exports: [RouterModule]
 })

 export class SlrdepartmentsRoutingModule {
 }

/**
 * @author Alex Gridin
 */

 import { NgModule } from '@angular/core';
 import { CommonModule } from '@angular/common';
 import { FormsModule } from '@angular/forms'
 import { SlrdepartmentService } from './slrdepartment.service';
 import { SlrdepartmentListComponent } from './slrdepartment-list/slrdepartment-list.component';
 import { SlrdepartmentDetailsComponent } from './slrdepartment-detail/slrdepartment-details.component';
 import { CreateSlrdepartmentComponent } from './slrdepartment-add/slrdepartment-add.component';
 import { SlrdepartmentEditComponent } from './slrdepartment-edit/slrdepartment-edit.component';
 import { SlrdepartmentsRoutingModule } from './slrdepartments-routing.module';

 @NgModule({
     imports: [
         CommonModule,
         FormsModule,
         SlrdepartmentsRoutingModule
     ],
     declarations: [
         SlrdepartmentListComponent,
         SlrdepartmentDetailsComponent,
         SlrdepartmentEditComponent,
         CreateSlrdepartmentComponent
     ],
     providers: [SlrdepartmentService]
 })

 export class SlrdepartmentsModule{
     
 }
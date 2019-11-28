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
 import { SlrdepartmentItemComponent } from './slrdepartment-item/slrdepartment-item.component';
 import { MatTreeModule} from '@angular/material/tree';
 import { MatTooltipModule} from '@angular/material/tooltip';
 import { MatIconModule} from '@angular/material/icon';
 import { SlrdepartmentSelectComponent } from './slrdepartment-select/slrdepartment-select.component';
 import { DialogOverviewTreeDepComponent } from './slrdepartment-select/dialog-overview-tree-dep/dialog-overview-tree-dep.component';
 import { MatFormFieldModule, MatInputModule } from '@angular/material';
 import { MatDialogModule, MatDialogClose} from '@angular/material/dialog';
 import { MatButtonModule } from '@angular/material';


 @NgModule({
     imports: [
         CommonModule,
         FormsModule,
         SlrdepartmentsRoutingModule,
         MatTreeModule,
         MatTooltipModule,
         MatIconModule,
         MatFormFieldModule,
         MatInputModule,
         MatDialogModule,
         MatButtonModule
     ],
     declarations: [
         SlrdepartmentListComponent,
         SlrdepartmentDetailsComponent,
         SlrdepartmentEditComponent,
         CreateSlrdepartmentComponent,
         SlrdepartmentItemComponent,
         SlrdepartmentSelectComponent,
         DialogOverviewTreeDepComponent
     ],
     exports: [
        SlrdepartmentListComponent,
        SlrdepartmentDetailsComponent,
        SlrdepartmentEditComponent,
        CreateSlrdepartmentComponent,
        SlrdepartmentItemComponent,
        SlrdepartmentSelectComponent,
        DialogOverviewTreeDepComponent,
        MatDialogClose,
        MatDialogModule,
        MatFormFieldModule,
        MatButtonModule,
        MatInputModule
     ],
     providers: [SlrdepartmentService],
     entryComponents: [SlrdepartmentSelectComponent, DialogOverviewTreeDepComponent]
 })

 export class SlrdepartmentsModule { }
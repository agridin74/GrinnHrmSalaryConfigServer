/**
 * @author Alex Gridin
 */
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UsrslrpaymentprizeService } from './usrslrpaymentprize.service';
import { UsrslrpaymentprizeRoutingModule } from './usrslrpaymentprize-routing.module';
import { UsrslrpaymentprizeListComponent } from './usrslrpaymentprize-list/usrslrpaymentprize-list.component';
import { UsrslrpaymentprizeEditComponent } from './usrslrpaymentprize-edit/usrslrpaymentprize-edit.component';
import { UsrslrpaymentprizeDetailComponent } from './usrslrpaymentprize-detail/usrslrpaymentprize-detail.component';
import { UsrslrpaymentprizeAddComponent } from './usrslrpaymentprize-add/usrslrpaymentprize-add.component';
import { SlrdepartmentsModule } from '../slrdepartments/slrdepartments.module'
import { SlrkadrsModule } from '../slrkadrs/slrkadrs.module';

import { MatMomentDateModule, MomentDateAdapter } from '@angular/material-moment-adapter';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';



export const MY_DATE_FORMATS = {
  parse: {
    dateInput: 'DD.MM.YYYY',
  },
  display: {
    dateInput: 'DD.MM.YYYY',
    monthYearLabel: 'MM YYYY',
    dateA11yLabel: 'DD.MM.YYYY',
    monthYearA11yLabel: 'MM YYYY',
  },
};

@NgModule({
  declarations: [
    UsrslrpaymentprizeListComponent,
    UsrslrpaymentprizeEditComponent,
    UsrslrpaymentprizeDetailComponent,
    UsrslrpaymentprizeAddComponent],
  imports: [
    CommonModule,
    FormsModule,
    MatDatepickerModule,
    MatMomentDateModule,
    UsrslrpaymentprizeRoutingModule,
    SlrdepartmentsModule,
    SlrkadrsModule
  ],
  exports: [
    UsrslrpaymentprizeListComponent,
    UsrslrpaymentprizeEditComponent,
    UsrslrpaymentprizeDetailComponent,
    UsrslrpaymentprizeAddComponent
  ],
  providers: [UsrslrpaymentprizeService,
  {provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE]},
  {provide: MAT_DATE_FORMATS, useValue: MY_DATE_FORMATS}
  ]
})
export class UsrslrpaymentprizeModule { }

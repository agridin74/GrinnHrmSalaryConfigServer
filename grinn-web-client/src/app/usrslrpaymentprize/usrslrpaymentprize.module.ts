import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsrslrpaymentprizeRoutingModule } from './usrslrpaymentprize-routing.module';
import { UsrslrpaymentprizeListComponent } from './usrslrpaymentprize-list/usrslrpaymentprize-list.component';
import { UsrslrpaymentprizeEditComponent } from './usrslrpaymentprize-edit/usrslrpaymentprize-edit.component';
import { UsrslrpaymentprizeDetailComponent } from './usrslrpaymentprize-detail/usrslrpaymentprize-detail.component';
import { UsrslrpaymentprizeAddComponent } from './usrslrpaymentprize-add/usrslrpaymentprize-add.component';

@NgModule({
  declarations: [UsrslrpaymentprizeListComponent, UsrslrpaymentprizeEditComponent, UsrslrpaymentprizeDetailComponent, UsrslrpaymentprizeAddComponent],
  imports: [
    CommonModule,
    UsrslrpaymentprizeRoutingModule
  ]
})
export class UsrslrpaymentprizeModule { }

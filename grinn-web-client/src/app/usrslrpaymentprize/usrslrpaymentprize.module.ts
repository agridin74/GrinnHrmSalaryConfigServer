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

@NgModule({
  declarations: [
    UsrslrpaymentprizeListComponent,
    UsrslrpaymentprizeEditComponent, 
    UsrslrpaymentprizeDetailComponent, 
    UsrslrpaymentprizeAddComponent],
  imports: [
    CommonModule,
    FormsModule,
    UsrslrpaymentprizeRoutingModule
  ],
  providers: [UsrslrpaymentprizeService]
})
export class UsrslrpaymentprizeModule { }

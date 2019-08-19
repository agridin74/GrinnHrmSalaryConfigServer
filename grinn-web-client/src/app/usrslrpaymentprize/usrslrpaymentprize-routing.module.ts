/**
 * @author Alex Gridin
 */
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsrslrpaymentprizeDetailComponent } from './usrslrpaymentprize-detail/usrslrpaymentprize-detail.component';
import { UsrslrpaymentprizeListComponent } from './usrslrpaymentprize-list/usrslrpaymentprize-list.component';
import { UsrslrpaymentprizeEditComponent } from './usrslrpaymentprize-edit/usrslrpaymentprize-edit.component';
import { UsrslrpaymentprizeAddComponent } from './usrslrpaymentprize-add/usrslrpaymentprize-add.component';

const routesPrizes: Routes = [
  {path: 'usrslrpaymentprizes', component: UsrslrpaymentprizeListComponent},
  {path: 'usrslrpaymentprizes/add', component: UsrslrpaymentprizeAddComponent},
  {path: 'usrslrpaymentprizes/:id', component: UsrslrpaymentprizeDetailComponent},
  {path: 'usrslrpaymentprizes/:id/edit', component: UsrslrpaymentprizeEditComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routesPrizes)],
  exports: [RouterModule]
})
export class UsrslrpaymentprizeRoutingModule { }

/**
 * @author Alex Gridin
 */
import { Component, OnInit } from '@angular/core';
import { UsrslrpaymentprizeService } from '../usrslrpaymentprize.service';
import { Usrslrpaymentprize } from '../usrslrpaymentprize';
import { Router } from '@angular/router';

import * as moment from 'moment';

@Component({
  selector: 'app-usrslrpaymentprize-add',
  templateUrl: './usrslrpaymentprize-add.component.html',
  styleUrls: ['./usrslrpaymentprize-add.component.css']
})
export class UsrslrpaymentprizeAddComponent implements OnInit {

  entity: Usrslrpaymentprize;
  errorMessage: string;

  constructor(private entityService: UsrslrpaymentprizeService, private router: Router) {
    this.entity = {} as Usrslrpaymentprize;
   }

  ngOnInit() {
  }

  onSubmit(entity: Usrslrpaymentprize) {
    entity.id = null;
    // format output from datepicker to short string yyyy/mm/dd format
    entity.dperiod = moment(entity.dperiod).format('YYYY/MM/DD');
    this.entityService.addUsrslrpaymentprize(entity).subscribe(
      newEntity => {
        this.entity = newEntity;
        this.gotoUsrslrpaymentprizeList();
      },
      error => this.errorMessage = error as any
    );
  }

  gotoUsrslrpaymentprizeList() {
    this.router.navigate(['/usrslrpaymentprizes']);
  }

}

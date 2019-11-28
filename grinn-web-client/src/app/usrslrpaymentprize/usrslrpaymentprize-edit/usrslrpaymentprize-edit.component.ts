/**
 * @author Alex Gridin
 */
import { Component, OnInit } from '@angular/core';
import { UsrslrpaymentprizeService } from '../usrslrpaymentprize.service';
import { Usrslrpaymentprize } from '../usrslrpaymentprize';
import { ActivatedRoute, Router } from '@angular/router';

import * as moment from 'moment';

@Component({
  selector: 'app-usrslrpaymentprize-edit',
  templateUrl: './usrslrpaymentprize-edit.component.html',
  styleUrls: ['./usrslrpaymentprize-edit.component.css']
})
export class UsrslrpaymentprizeEditComponent implements OnInit {

  entity: Usrslrpaymentprize;
  errorMessage: string;

  constructor(private prizeService: UsrslrpaymentprizeService, private route: ActivatedRoute, private router: Router) {
    this.entity = {} as Usrslrpaymentprize;
   }

  ngOnInit() {
    const entityId = this.route.snapshot.params.id;
    this.prizeService.getUsrslrpaymentprizeById(entityId).subscribe(
      entity => this.entity = entity,
      error => this.errorMessage = error as any
    );
  }

  onSubmit(entity: Usrslrpaymentprize) {
    const that = this;
    entity.dperiod = moment(entity.dperiod).format('DD.MM.YYYY');
    this.prizeService.updateUsrslrpaymentprize(entity.id.toString(), entity).subscribe(
      res => this.gotoUsrslrpaymentprizeDetail(entity),
      error => this.errorMessage = error as any
    );
  }

  gotoUsrslrpaymentprizeDetail(entity: Usrslrpaymentprize) {
    this.errorMessage = null;
    this.router.navigate(['/usrslrpaymentprizes', entity.id.toString()]);
  }

}

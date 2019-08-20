/**
 * @author Alex Gridin
 */
import { Component, OnInit } from '@angular/core';
import { UsrslrpaymentprizeService } from '../usrslrpaymentprize.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Usrslrpaymentprize } from '../usrslrpaymentprize';

@Component({
  selector: 'app-usrslrpaymentprize-detail',
  templateUrl: './usrslrpaymentprize-detail.component.html',
  styleUrls: ['./usrslrpaymentprize-detail.component.css']
})
export class UsrslrpaymentprizeDetailComponent implements OnInit {
  errorMessage: string;
  entity: Usrslrpaymentprize;

  constructor(private route: ActivatedRoute, private router: Router, private entityService: UsrslrpaymentprizeService) {
    this.entity = {} as Usrslrpaymentprize;
   }

  ngOnInit() {
    const entityId = this.route.snapshot.params.id;
    this.entityService.getUsrslrpaymentprizeById(entityId).subscribe(
      entity => this.entity = entity,
      error => this.errorMessage = error as any
    );
  }

  gotoUsrslrpaymentprizeList() {
    this.router.navigate(['/usrslrpaymentprizes']);
  }

  editUsrslrpaymentprize(){
    this.router.navigate(['/usrslrpaymentprizes', this.entity.id, 'edit']);
  }

}

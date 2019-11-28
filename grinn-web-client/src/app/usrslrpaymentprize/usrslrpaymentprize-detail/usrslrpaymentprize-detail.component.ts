/**
 * @author Alex Gridin
 */
import { Component, OnInit } from '@angular/core';
import { UsrslrpaymentprizeService } from '../usrslrpaymentprize.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Usrslrpaymentprize } from '../usrslrpaymentprize';
import { Slrkadr } from '../../slrkadrs/slrkadr';
import { SlrkadrService } from '../../slrkadrs/slrkadr.service';

@Component({
  selector: 'app-usrslrpaymentprize-detail',
  templateUrl: './usrslrpaymentprize-detail.component.html',
  styleUrls: ['./usrslrpaymentprize-detail.component.css']
})
export class UsrslrpaymentprizeDetailComponent implements OnInit {
  errorMessage: string;
  entity: Usrslrpaymentprize;
  slrkadr: Slrkadr;

  constructor(private route: ActivatedRoute, private router: Router, 
    private entityService: UsrslrpaymentprizeService,
    private slrkadrService: SlrkadrService) {
    this.entity = {} as Usrslrpaymentprize;
    this.slrkadr = {} as Slrkadr;
   }

  ngOnInit() {
    const entityId = this.route.snapshot.params.id;
    this.entityService.getUsrslrpaymentprizeById(entityId).subscribe(
      entity => this.entity = entity,
      error => this.errorMessage = error as any
    );
      var slrkadrId: string;
      slrkadrId = this.entity.idkadr.toString();
    this.slrkadrService.getSlrkadrById(slrkadrId).subscribe(
      slrkadr => this.slrkadr = slrkadr,
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

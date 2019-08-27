/**
 * @author Alex Gridin
 */
import { Component, OnInit } from '@angular/core';
import { UsrslrpaymentprizeService } from '../usrslrpaymentprize.service';
import { Usrslrpaymentprize } from '../usrslrpaymentprize';
import { Router } from '@angular/router';


@Component({
  selector: 'app-usrslrpaymentprize-list',
  templateUrl: './usrslrpaymentprize-list.component.html',
  styleUrls: ['./usrslrpaymentprize-list.component.css']
})
export class UsrslrpaymentprizeListComponent implements OnInit {

  errorMessage: string;
  usrslrpaymentprizes: Usrslrpaymentprize[];

  constructor(private router: Router, private usrslrpaymentprizeService: UsrslrpaymentprizeService) {
     }

  ngOnInit() {
    this.usrslrpaymentprizeService.getUsrslrpaymentprizes().subscribe(
      entitys => this.usrslrpaymentprizes = entitys,
      error => this.errorMessage = error as any
    );
  }

  onSelect(entity: Usrslrpaymentprize) {
    this.router.navigate(['/usrslrpaymentprizes', entity.id]);
  }

  addUsrslrpaymentprize(){
    this.router.navigate(['/usrslrpaymentprizes/add']);
  }

}

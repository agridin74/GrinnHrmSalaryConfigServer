/**
 * @author Alex Gridin
 */
import { Component, OnInit, EventEmitter } from '@angular/core';
import { UsrslrpaymentprizeService } from '../usrslrpaymentprize.service';
import { Usrslrpaymentprize } from '../usrslrpaymentprize';
import { Router } from '@angular/router';
import { Slrdepartment } from '../../slrdepartments/slrdepartment';
import { SlrdepartmentDetailsComponent } from 'src/app/slrdepartments/slrdepartment-detail/slrdepartment-details.component';
import { UsrslrpaymentprizeSearch } from '../usrslrpaymentprize-search';

@Component({
  selector: 'app-usrslrpaymentprize-list',
  templateUrl: './usrslrpaymentprize-list.component.html',
  styleUrls: ['./usrslrpaymentprize-list.component.css']
})
export class UsrslrpaymentprizeListComponent implements OnInit {
  name: string;
  search: UsrslrpaymentprizeSearch;
  errorMessage: string;
  usrslrpaymentprizes: Usrslrpaymentprize[];

  constructor(private router: Router, private usrslrpaymentprizeService: UsrslrpaymentprizeService) {
    this.search = {} as UsrslrpaymentprizeSearch;
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

  addUsrslrpaymentprize() {
    this.router.navigate(['/usrslrpaymentprizes/add']);
  }

  slrdepartmentWasSelected(slrdepartment: Slrdepartment): void {
    console.log('Slrdepartment clicked: ', slrdepartment);
    this.search.slrdepartment = slrdepartment ;
  }

}

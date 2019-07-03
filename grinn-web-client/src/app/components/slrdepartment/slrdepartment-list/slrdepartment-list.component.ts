import { Component, OnInit } from '@angular/core';
import { SlrdepartmentDetailsComponent } from '../slrdepartment-details/slrdepartment-details.component';
import { Observable } from 'rxjs';
import { SlrdepartmentService } from '../../../services/slrdepartment.service';
import { Slrdepartment } from '../../../entity/slrdepartment';
import { Router } from '@angular/router';


@Component({
  selector: 'app-slrdepartment-list',
  templateUrl: './slrdepartment-list.component.html',
  styleUrls: ['./slrdepartment-list.component.css']
})
export class SlrdepartmentListComponent implements OnInit {
  slrdepartments: Observable<Slrdepartment[]>;

  constructor(private slrdepartmentService: SlrdepartmentService,
              private router: Router ) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.slrdepartments = this.slrdepartmentService.getSlrdepartmentsList();
  }

  deleteSlrdepartment(id: number){
    this.slrdepartmentService.deleteSlrdepartment(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  slrdepartmentDetails(id: number){
    this.router.navigate(['details', id]);
  }

}

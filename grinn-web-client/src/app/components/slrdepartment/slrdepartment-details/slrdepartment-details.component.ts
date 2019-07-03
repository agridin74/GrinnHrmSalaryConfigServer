import { Component, OnInit, Input } from '@angular/core';
import { Slrdepartment } from '../../../entity/slrdepartment';
import { SlrdepartmentService } from '../../../services/slrdepartment.service';
import { SlrdepartmentListComponent } from '../slrdepartment-list/slrdepartment-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-slrdepartment-details',
  templateUrl: './slrdepartment-details.component.html',
  styleUrls: ['./slrdepartment-details.component.css']
})
export class SlrdepartmentDetailsComponent implements OnInit {

  id: number;
  slrdepartment: Slrdepartment;

  constructor(private route: ActivatedRoute, private router: Router,
      private slrdepartmentService: SlrdepartmentService) { }

  ngOnInit() {
    this.slrdepartment = new Slrdepartment();
    this.id = this.route.snapshot.params['id'];
    this.slrdepartmentService.getSlrdepartment(this.id)
      .subscribe(data =>{
        console.log(data);
        this.slrdepartment = data;
      }, error => console.log(error));
  }
  list(){
    this.router.navigate(['slrdepartments']);
  }

}

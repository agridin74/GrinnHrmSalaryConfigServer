/**
 * @author Alex Gridin
 */
import { Component, OnInit } from '@angular/core';
import { SlrdepartmentService } from '../slrdepartment.service';
import { Slrdepartment } from '../slrdepartment';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-slrdepartment-edit',
  templateUrl: './slrdepartment-edit.component.html',
  styleUrls: ['./slrdepartment-edit.component.css']
})
export class SlrdepartmentEditComponent implements OnInit {

  slrdepartment: Slrdepartment;
  errorMessage: string;

  constructor(private slrdepartmentService: SlrdepartmentService, private route: ActivatedRoute, 
    private router: Router ) {
      this.slrdepartment = {} as Slrdepartment;
     }

  ngOnInit() {
    const entityid = this.route.snapshot.params.id;
    this.slrdepartmentService.getSlrdepartmentById(entityid).subscribe(
      sledepartment => this.slrdepartment = this.slrdepartment,
      error => this.errorMessage = error as any
    );
  }

  onSubmit(slrdepartment: Slrdepartment){
    const that = this;
    this.slrdepartmentService.updateSlrdepartment(slrdepartment.id.toString(), slrdepartment).subscribe(
      res => this.gotoSlrdepartmentDetail(slrdepartment),
      error => this.errorMessage = error as any
    );
  }

  gotoSlrdepartmentDetail(slrdepartment: Slrdepartment){
    this.errorMessage = null,
    this.router.navigate(['/slrdepartments', slrdepartment.id]);
  }

}

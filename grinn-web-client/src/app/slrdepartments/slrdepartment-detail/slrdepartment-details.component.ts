/**
 * @author Alex Gridin
 */
import { Component, OnInit, Input } from '@angular/core';
import { Slrdepartment } from '../slrdepartment';
import { SlrdepartmentService } from '../slrdepartment.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-slrdepartment-details',
  templateUrl: './slrdepartment-details.component.html',
  styleUrls: ['./slrdepartment-details.component.css']
})
export class SlrdepartmentDetailsComponent implements OnInit {
  errorMessage: string;
  slrdepartment: Slrdepartment;
  //id: number;
  //slrdepartment: Slrdepartment;

  constructor(private route: ActivatedRoute, private router: Router,
      private slrdepartmentService: SlrdepartmentService) { 
        this.slrdepartment = {} as Slrdepartment;
      }

  ngOnInit() {
    const slrdepartmentId = this.route.snapshot.params.id;
    this.slrdepartmentService.getSlrdepartmentById(slrdepartmentId).subscribe(
      slrdepartment => this.slrdepartment = slrdepartment,
      error => this.errorMessage = error as any
    );
    /*this.slrdepartment = new Slrdepartment();
    this.id = this.route.snapshot.params['id'];
    this.slrdepartmentService.getSlrdepartment(this.id)
      .subscribe(data =>{
        console.log(data);
        this.slrdepartment = data;
      }, error => console.log(error));*/
  }
  /*list(){
    this.router.navigate(['slrdepartments']);
  }*/

  gotoSlrdepartmentsList(){
    this.router.navigate(['/slrdepartments']);
  }

  editSlrdepartment(){
    this.router.navigate(['/slrdepartments', this.slrdepartment.id, 'edit']);
  }
  

}

import { Component, OnInit, Input } from '@angular/core';
import { Slrdepartment } from '../slrdepartment';
import { SlrdepartmentService } from '../slrdepartment.service';

@Component({
  selector: 'app-slrdepartment-item',
  templateUrl: './slrdepartment-item.component.html',
  styleUrls: ['./slrdepartment-item.component.css']
})
export class SlrdepartmentItemComponent implements OnInit {
  errorMessage: string;
  slrdepartment: Slrdepartment;
  @Input() slrdepartmentId: string;

  constructor(private slrdepartmentService: SlrdepartmentService) { 
    this.slrdepartment = {} as Slrdepartment;
  }

  ngOnInit() {
    this.slrdepartmentService.getSlrdepartmentById(this.slrdepartmentId).subscribe(
      slrdepartment => this.slrdepartment = slrdepartment,
      error => this.errorMessage = error as any
    );
  }

}

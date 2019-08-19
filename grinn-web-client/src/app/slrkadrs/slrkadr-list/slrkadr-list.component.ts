/**
 * @author Alex Gridin
 */
import { Component, OnInit } from '@angular/core';
import { SlrkadrService } from '../slrkadr.service';
import { Slrkadr } from '../slrkadr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-slrkadr-list',
  templateUrl: './slrkadr-list.component.html',
  styleUrls: ['./slrkadr-list.component.css']
})
export class SlrkadrListComponent implements OnInit {

  errorMessage: string;
  slrkadrs: Slrkadr[];

  constructor(private router: Router, private slrkadrService: SlrkadrService) { }

  ngOnInit() {
    this.slrkadrService.getSlrkadrs().subscribe(
      slrkadrs => this.slrkadrs = slrkadrs,
      error => this.errorMessage = error as any
    );
  }

  onSelect(slrkadr: Slrkadr) {
    this.router.navigate(['/slrkadrs', slrkadr.id]);
  }

  addSlrkadr(){
    this.router.navigate(['/slrkadrs/add']);
  }

}

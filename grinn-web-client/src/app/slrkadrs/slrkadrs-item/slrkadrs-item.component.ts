import { Component, OnInit, Input } from '@angular/core';
import { Slrkadr } from '../slrkadr';
import { SlrkadrService } from '../slrkadr.service';

@Component({
  selector: 'app-slrkadrs-item',
  templateUrl: './slrkadrs-item.component.html',
  styleUrls: ['./slrkadrs-item.component.css']
})
export class SlrkadrsItemComponent implements OnInit {
  errorMessage: string;
  slrkadr: Slrkadr;
  @Input() slrkadrId: string;

  constructor(private slrkadrService: SlrkadrService) {
    this.slrkadr = {} as Slrkadr;
   }

  ngOnInit() {
    this.slrkadrService.getSlrkadrById(this.slrkadrId).subscribe(
      slrkadr => this.slrkadr = slrkadr,
      error => this.errorMessage = error as any
    );
  }

}

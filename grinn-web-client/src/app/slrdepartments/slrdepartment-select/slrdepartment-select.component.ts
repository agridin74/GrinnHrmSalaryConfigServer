import { Component, OnInit, EventEmitter, Input, Output, Inject } from '@angular/core';
import { SlrdepartmentService } from '../slrdepartment.service';
import { Slrdepartment } from '../slrdepartment';
import { NestedTreeControl } from '@angular/cdk/tree';
import { MatTreeNestedDataSource } from '@angular/material/tree';
import { TreeItem } from '../tree-item';
import { DialogOverviewTreeDepComponent} from './dialog-overview-tree-dep/dialog-overview-tree-dep.component';
import { DialogData } from '../dialog-data';

import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';




/*export interface TreeItem {
  data: Slrdepartment | null;
  children: TreeItem[];

  <products-list
[productList]="products"
(onProductSelected)="productWasSelected($event)">
</products-list>

}*/

@Component({
  selector: 'app-slrdepartment-select',
  templateUrl: './slrdepartment-select.component.html',
  styleUrls: ['./slrdepartment-select.component.css']
})
export class SlrdepartmentSelectComponent implements OnInit {

  animal: string;
  name: string;

  //@Input() slrdepartmentsList: Slrdepartment[];

  /**
   * @output slrdepartmentSelected - outputs the current
   *          Slrdepartment whenever a new Slrdepartment is selected
   */
  @Output() slrdepartmentSelected: EventEmitter<Slrdepartment>;

  /**
   * @property currentSlrdepartment - local state containing
   *             the currently selected `Slrdepartment`
   */
  currentSlrdepartment: Slrdepartment;

  errorMessage: string;
  slrdepartments: Slrdepartment[];
  treeItem: TreeItem[];

  //treeControl = new NestedTreeControl<TreeItem>(node => node.children);
  //dataSource = new MatTreeNestedDataSource<TreeItem>();

  constructor(private slrdepartmentService: SlrdepartmentService, public dialog: MatDialog) { 
    this.slrdepartmentSelected = new EventEmitter();
  }

  //hasChild = (_: number, node: TreeItem) => !!node.children && node.children.length > 0;

  ngOnInit() {
    this.slrdepartmentService.getSlrdepartments().subscribe(
      slrdepartments => {
        this.slrdepartments = slrdepartments;
        this.treeItem = this.toTree(this.slrdepartments);
        //this.dataSource.data = this.treeItem;
      },
      error => this.errorMessage = error as any
    );
    this.currentSlrdepartment = {} as Slrdepartment;
  }

  toTree(items: Slrdepartment[]): TreeItem[] {
    const rootItems: TreeItem[] = [];
    const lookup: { [id: string]: TreeItem } = {};
    for (const item of items) {
      const itemId = item.id;
      const parentId = item.idparent;
      if (!Object.prototype.hasOwnProperty.call(lookup, itemId)){
        lookup[itemId] = { data: null, children: []};
      }
      lookup[itemId].data = item;
      const TreeItem = lookup[itemId];

      if (!items.find(myObj => myObj.id === parentId)) {
        rootItems.push(TreeItem);
      } else {
        if (!Object.prototype.hasOwnProperty.call(lookup, parentId)){
          lookup[parentId] = { data: null, children: [] };
        }
        lookup[parentId].children.push(TreeItem);
      }
    }
    return rootItems;
  }

  cliced(slrdepartment: Slrdepartment): void {
    this.currentSlrdepartment = slrdepartment;
    this.slrdepartmentSelected.emit(slrdepartment);
  }

  isSelected(slrdepartment: Slrdepartment): boolean {

    if (!slrdepartment || !this.currentSlrdepartment) {
      return false;
    }
    return slrdepartment.id === this.currentSlrdepartment.id;
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(DialogOverviewTreeDepComponent, {
      width: '450px',
      data: {name: this.name, animal: this.animal, slrdepartment: this.currentSlrdepartment, treeItem: this.treeItem }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.currentSlrdepartment = result;
      this.slrdepartmentSelected.emit(this.currentSlrdepartment);
      //this.animal = result;
      console.log(`Dialog result: ${this.currentSlrdepartment.snm}`);
    });
  }
}



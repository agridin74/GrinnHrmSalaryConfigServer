/**
 * @author Alex Gridin
 */
import { Component, OnInit } from '@angular/core';
import { SlrdepartmentService } from '../slrdepartment.service';
import { Slrdepartment } from '../slrdepartment';
import { Router } from '@angular/router';
import { NestedTreeControl } from '@angular/cdk/tree';
import { MatTreeNestedDataSource } from '@angular/material/tree';
import { TreeItem } from '../tree-item';



/*export interface TreeItem {
  data: Slrdepartment | null;
  children: TreeItem[];
}*/

@Component({
  selector: 'app-slrdepartment-list',
  templateUrl: './slrdepartment-list.component.html',
  styleUrls: ['./slrdepartment-list.component.css']
})
export class SlrdepartmentListComponent implements OnInit {
  errorMessage: string;
  slrdepartments: Slrdepartment[];
  treeItem: TreeItem[];

  treeControl = new NestedTreeControl<TreeItem>(node => node.children);
  dataSource = new MatTreeNestedDataSource<TreeItem>();

  constructor(private router: Router, private slrdepartmentService: SlrdepartmentService ) { }

  hasChild = (_: number, node: TreeItem) => !!node.children && node.children.length > 0;

  ngOnInit() {
    this.slrdepartmentService.getSlrdepartments().subscribe(
      slrdepartments => {
        this.slrdepartments = slrdepartments;
      //  var tree = this.slrdepartments.reduce(this.toTree, {})['1'];// получаем только корневой узел ('1')
      //  console.log(tree);
        this.treeItem = this.toTree1(this.slrdepartments);
      //  console.log(tree);
        this.dataSource.data = this.treeItem;
      },
      error => this.errorMessage = error as any
    );

  }

  onSelect(slrdepartment: Slrdepartment) {
    this.router.navigate(['/slrdepartments', slrdepartment.id]);
  }

  addSlrdepartment() {
    this.router.navigate(['/slrdepartments/add']);
  }

   toTree(branches, node) {
    // если нет родителя
    if (!branches[node.idparent]) {
      // создаем фиктивный заполнитель на данный момент
      branches[node.idparent] = {};
    }
    // сохранить наш узел в его родительском
    branches[node.idparent][node.id] = node;
    // храним наш узел в полном списке
   // копировать все добавленные ветки на возможный заполнитель
    branches[node.id] = Object.assign(node, branches[node.id]);

    return branches;

  }
  // взял с github autor philipstanislaus
  // сам придумать кроме рекурсии не смог видимо наступает дименция
   toTree1 (items: Slrdepartment[], ): TreeItem[] {

    // результирующее  дерево
    const rootItems: TreeItem[] = [];

    // сохраняет все уже обработанные элементы с их детьми в качестве ключа, чтобы мы могли легко найти их
    const lookup: { [id: string]: TreeItem } = {};

    // идея этого цикла:
    // всякий раз, когда у элемента есть родитель, но родитель еще не находится в объекте поиска, мы сохраняем предварительный родитель
    // в объект поиска и позже заполняем его данными родителя
    // если у элемента нет parentId, добавьте его как корневой элемент в rootItems
    for (const item of items) {
      const itemId = item.id;
      const parentId = item.idparent;

      // посмотреть, существует ли элемент в таблице поиска
      if (!Object.prototype.hasOwnProperty.call(lookup, itemId)) {
        // элемента еще нет, поэтому добавьте предварительный элемент (его данные будут добавлены позже)
        lookup[itemId] = { data: null, children: [] };
      }

      // добавляем данные текущего элемента к элементу в таблице поиска
      lookup[itemId].data = item;

      const TreeItem = lookup[itemId];

      // if (parentId === null || !items[parentId]) {
      if (!items.find(myObj => myObj.id ===parentId)) {
        // является корневым элементом
        rootItems.push(TreeItem);
      } else {
        // есть родитель
        // посмотреть, существует ли родитель в таблице поиска
        if (!Object.prototype.hasOwnProperty.call(lookup, parentId)) {
          // родителя еще нет, поэтому добавьте предварительного родителя (его данные будут добавлены позже)
          lookup[parentId] = { data: null, children: [] };
        }

       // добавляем текущий элемент к родителю
        lookup[parentId].children.push(TreeItem);
      }
    }

    return rootItems;

  }
}

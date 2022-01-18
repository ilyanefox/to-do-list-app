import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {Component} from '@angular/core';
import {MatChipInputEvent} from '@angular/material/chips';

export interface Categories {
  name: string
}

// @Component({
//   selector: 'chips-input-example',
//   templateUrl: 'chips-input-example.html',
//   styleUrls: ['chips-input-example.css'],
// })
// export class ChipsInputExample {
//   addOnBlur = true;
//   readonly separatorKeysCodes = [ENTER, COMMA] as const;
//   categories: Categories[] = [];
//
//   add(event: MatChipInputEvent): void {
//     const value = (event.value || '').trim();
//
//     // Add our fruit
//     if (value) {
//       this.categories.push({name: value});
//     }
//
//     // Clear the input value
//     event.chipInput!.clear();
//   }
//
//   remove(category: Categories): void {
//     const index = this.categories.indexOf(category);
//
//     if (index >= 0) {
//       this.categories.splice(index, 1);
//     }
//   }
// }

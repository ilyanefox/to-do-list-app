export class User {
  id: number | undefined;
  email: string | undefined;
  pwHash: string | undefined;
  firstName: string | undefined;
  categories: string[] | undefined;
  toDoList: string | undefined;
}

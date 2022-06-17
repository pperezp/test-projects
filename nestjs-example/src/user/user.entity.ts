import { Entity, Column, PrimaryGeneratedColumn } from 'typeorm';

@Entity({ name: 'aw_user' })
export class User {
  @PrimaryGeneratedColumn({ name: 'user_id' })
  id: number;

  @Column({ name: 'fname' })
  firstName: string;

  @Column({ name: 'lname' })
  lastName: string;

  @Column({ name: 'email_id' })
  email: string;
}

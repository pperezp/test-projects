import { Exclude, Expose } from '@nestjs/class-transformer';

@Exclude()
export class UserDto {
  @Expose({ name: 'id' })
  readonly identify: number;

  @Expose({ name: 'email' })
  readonly mail: string;

  fullName: string;
}

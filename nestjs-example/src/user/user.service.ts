import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { User } from './user.entity';
import { Repository } from 'typeorm';
import { UserDto } from './dto/user.dto';
import { plainToClass } from '@nestjs/class-transformer';

@Injectable()
export class UserService {
  constructor(
    @InjectRepository(User)
    private usersRepository: Repository<User>,
  ) {}

  public async findOne(id: string): Promise<UserDto> {
    const user = await this.usersRepository.findOne(id);
    const userDto = await plainToClass(UserDto, user);
    console.log(userDto);
    userDto.fullName = user.firstName + ' ' + user.lastName;

    return userDto;
  }
}

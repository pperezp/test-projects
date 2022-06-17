import { Controller, Get, Param } from '@nestjs/common';
import { UserService } from './user.service';
import { UserDto } from './dto/user.dto';

@Controller('users')
export class UserController {
  constructor(private userService: UserService) {}

  @Get('/:id')
  public async findOne(@Param('id') id: string): Promise<UserDto> {
    return await this.userService.findOne(id);
  }
}

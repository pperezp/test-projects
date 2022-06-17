import {
  Controller,
  Get,
  HttpCode,
  HttpStatus,
  Param,
  Query,
  Res,
} from '@nestjs/common';
import { Response } from 'express';

@Controller('test')
export class TestController {
  @HttpCode(204)
  @Get('/no-content')
  public noContent() {
    console.log('no content');
  }

  @Get('/conflict')
  public conflict(@Res() response: Response): Response {
    return response.status(HttpStatus.CONFLICT).send('');
  }

  @Get('/params')
  public params(@Query() params: any) {
    console.log(params.error);
    if (params.error === 'true') {
      console.log('ERROR');
    } else {
      console.log('NO');
    }
  }

  @Get('/params/:id')
  public params2(@Param('id') id: string) {
    console.log(Number.parseInt(id));
  }
}

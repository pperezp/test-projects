import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { UserModule } from './user/user.module';
import { TestModule } from './test/test.module';

@Module({
  imports: [TypeOrmModule.forRoot(), UserModule, TestModule],
})
export class AppModule {}

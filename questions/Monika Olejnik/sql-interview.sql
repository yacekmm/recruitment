create table runners(
	id  SERIAL primary key,
	name varchar(20) not null	
)

create table events(
 id SERIAL primary key,
 name varchar(20) not null
)

create table winners(
 events_id SERIAL not null references events(id),
 runners_id SERIAL not null references runners(id)
)

insert into events(name) values ('marathon');
insert into events(name) values ('runmageddon');

insert into runners(name) values ('Ala Looser')
insert into runners(name) values ('Iron man')
insert into runners(name) values ('Terminator')

select * from runners


insert into winners values (1,2)
insert into winners values (2,2)
insert into winners values (1,3)

select * from winners

# List runners that did not win

select r.* from runners r
left outer join winners w on (w.runners_id=r.id)
where w.runners_id is null

select r.id,r.name from runners r
join winners w on (w.runners_id=r.id)
group by r.id,r.name
having count (w.events_id) > 1

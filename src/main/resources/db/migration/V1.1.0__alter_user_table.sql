alter table `user`
    add column profile varchar(255),
    add column about   varchar(255),
    add column title   varchar(50);

update `user`
set profile = '/img/author.jpg',
    about   = 'Vivamus volutpat nibh ac sollicitudin imperdiet. Donec scelerisque lorem sodales odio ultricies, nec rhoncus ex lobortis. Vivamus tincid-unt sit amet sem id varius. Donec elementum aliquet tortor. Curabitur justo mi, efficitur sed eros alique.',
    title   = 'title';
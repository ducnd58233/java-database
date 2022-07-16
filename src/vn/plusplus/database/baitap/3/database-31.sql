USE store_cms_plusplus;
SELECT * FROM laptop;

-- 1. Tìm kiếm các laptop có ram từ 4GB đến 8GB (Bao gồm cả 2 giá trị này)
SELECT * FROM `laptop` WHERE`ram` >= '4GB' AND `ram` <= '8GB';

-- 2. Tìm kiếm các laptop có ram=8GB, ssd=256GB
SELECT * FROM `laptop` WHERE `ram`='8GB' AND `ssd`='256GB';

-- 3. Tìm kiếm các laptop có maker chứa ký tự "a"
SELECT * FROM `laptop` WHERE `maker` LIKE '%a%';

-- 4. Tìm kiếm các laptop có cpu là Intel
SELECT * FROM `laptop` WHERE `cpu` LIKE '%Intel%';

-- 5. Tìm kiếm các laptop có sold > 30 và sắp xếp các laptop theo giá giảm dần.
SELECT * FROM `laptop` WHERE `sold` > 30 ORDER BY `price` DESC;
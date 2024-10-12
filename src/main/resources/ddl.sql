
CREATE TABLE `parking_lot`
(
    `lot_id` varchar(50) NOT NULL DEFAULT '',
    `location` varchar(100) NOT NULL DEFAULT '',
    `capacity` bigint NOT NULL DEFAULT 0,
    `occupied` bigint NOT NULL DEFAULT 0,
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `created_by` varchar(20) NOT NULL DEFAULT 'System',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_by` varchar(20) NOT NULL DEFAULT 'System',
    PRIMARY KEY (`lot_id`)
);

CREATE TABLE `vehicle`
(
    `plate_id` varchar(20) NOT NULL DEFAULT '',
    `vehicle_type` varchar NOT NULL DEFAULT '',
    `owner_name` varchar(50) NOT NULL DEFAULT '',
    `lot_id`  varchar(50) NOT NULL DEFAULT '',
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `created_by` varchar(20) NOT NULL DEFAULT 'System',
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_by` varchar(20) NOT NULL DEFAULT 'System',
    PRIMARY KEY (`plate_id`)
);
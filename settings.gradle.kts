rootProject.name = "farmasterrae"

include("common-library")
include("auth-service")
include("notification-service")
include("api-gateway")

include(":user-management:user-command-service")
include(":user-management:user-query-service")

include(":product-catalog:product-command-service")
include(":product-catalog:product-query-service")

include(":sales:sales-command-service")
include(":sales:sales-query-service")
include("product-catalog:untitled")
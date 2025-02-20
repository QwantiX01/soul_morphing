# Вкажіть шлях до папки з текстурами
$texturesFolder = "path/to/textures"
# Вкажіть шлях до вихідної папки
$outputFolder = "path/to/output"

# Визначаємо шляхи для створення файлів
$blockStatesFolder = Join-Path $outputFolder "blockstates"
$modelsBlockFolder = Join-Path $outputFolder "models/block"
$modelsItemFolder = Join-Path $outputFolder "models/item"
$texturesOutputFolder = Join-Path $outputFolder "textures/block"

# Створюємо папки, якщо їх немає
New-Item -ItemType Directory -Force -Path $blockStatesFolder, $modelsBlockFolder, $modelsItemFolder, $texturesOutputFolder

# Обробка кожного файлу текстури
Get-ChildItem -Path $texturesFolder -File | ForEach-Object {
    $textureName = $_.BaseName # Назва текстури без розширення

    # Назва в UPPER_CASE для Java-коду
    $textureNameUpper = $textureName.ToUpper()

    # Створення Java-файлу
    $javaContent = @"
    public static final DeferredHolder<Block, Block> $textureNameUpper = BLOCKS.registerSimpleBlock(
        "$textureName",
        BlockBehaviour.Properties.of()
            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "$textureName"))));
"@
    $javaFile = Join-Path $outputFolder "$textureName.java"
    Set-Content -Path $javaFile -Value $javaContent

    # Створення blockstates JSON
    $blockStateContent = @"{
  "variants": {
    "": {
      "model": "soul_morphing:block/$textureName"
    }
  }
}"@
    $blockStateFile = Join-Path $blockStatesFolder "$textureName.json"
    Set-Content -Path $blockStateFile -Value $blockStateContent

    # Створення models/block JSON
    $modelBlockContent = @"{
  "parent": "minecraft:block/cube_all",
  "textures": {
    "all": "soul_morphing:block/$textureName"
  }
}"@
    $modelBlockFile = Join-Path $modelsBlockFolder "$textureName.json"
    Set-Content -Path $modelBlockFile -Value $modelBlockContent

    # Створення models/item JSON
    $modelItemContent = @"{
  "parent": "soul_morphing:block/$textureName",
  "display": {
    "thirdperson": {
      "rotation": [
        10,
        -45,
        170
      ],
      "translation": [
        0,
        1.5,
        -2.75
      ],
      "scale": [
        0.375,
        0.375,
        0.375
      ]
    }
  }
}"
    $modelItemFile = Join-Path $modelsItemFolder "$textureName.json"
    Set-Content -Path $modelItemFile -Value $modelItemContent

    # Копіювання текстури в textures/block
    Copy-Item -Path $_.FullName -Destination $texturesOutputFolder -Force
}
